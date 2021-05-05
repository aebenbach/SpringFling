import processing.core.*; 

public class Game extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Game");
		
	}
	//initialize variables
	Player player;
	boolean left_pressed;
	boolean right_pressed;
	float cam_speed;
	float score;
	Ledge[] level1;
	Ledge[] level2;
	
	public void settings() {  
		size(400,500); 
	}
	public void setup() {
		
		background(0);
		cam_speed = 0;
		score = 0;
		player = new Player();
		
		//infinite, random generation works by creating two chunks at a time called levels
		level1 = new Ledge[6];
		level2 = new Ledge[6];
		generateLevel(level1,0);
		//starting ledge 
		level1[0] = new Ledge(190,490,0,0);
		generateLevel(level2, 500);
	}
	
	//detecting which buttons have been pressed.
	//the players speed cannot be adjusted directly through these methods because otherwise when both buttons are 
	//pressed the player will move in the most recently pressed direction
	public void keyPressed() {

		if (key == 'a') {
			left_pressed = true;
		}
		if (key == 'd') {
			right_pressed = true;
		}
	}
	//detecting which buttons have been released
	public void keyReleased() {

		if (key == 'a') {
			left_pressed = false;
		}
		if (key == 'd'){
			right_pressed = false;
		}
	}
	public void draw() {
		//function resolves the x speed of the player at this particular frame
		player.resolveX(left_pressed,right_pressed);
		
		//checks if player has landed, and if so jumps
		if (isLanded(player, level1,level2)) {
			player.y_speed = -9f;
		}
		else if (player.y_speed < 8f){
			player.y_speed += .20f;
		}
		
		//moves camera at player speed if player is halfway up screen
		if (player.y_pos < 250f && player.y_speed < 0f) {
			cam_speed = player.y_speed * -1;
		}
		else {
			cam_speed = 0f;
		}
		//cam speed also happens to be the players additional score for each frame
		score += cam_speed;
		
		//update and display everything
		background(0);
		updateLevel(level1,level2,cam_speed);
		displayLevel(level1,level2,this);
		player.update(cam_speed);
		player.display(this);
	}
	
	//iterates through all ledges to check if player has landed on any of them
	public static boolean isLanded(Player player, Ledge[] level1, Ledge[] level2) {
		for(Ledge ledge : level1) {
			if (player.x_pos >= ledge.x_pos-10f && player.x_pos <= ledge.x_pos+35f 
					&& player.y_pos >= ledge.y_pos && player.y_pos <= ledge.y_pos + 10 && player.y_speed>0) {
				return true;
			}
		}
		for(Ledge ledge : level2) {
			if (player.x_pos >= ledge.x_pos-10f && player.x_pos <= ledge.x_pos+35f 
					&& player.y_pos >= ledge.y_pos && player.y_pos <= ledge.y_pos + 10 && player.y_speed>0) {
				return true;
			}
		}
		return false;
		
	}
	
	//generates new chunk of ledges when one goes past screen
	public static void generateLevel(Ledge[] level, float height) {
		float interval = (500 / level.length);
		for(int x=0; x < level.length ; x++) {
			float x_pos = (float)(Math.random() * 376);
			if (Math.random() <= .15) {
				System.out.print('a');
				level[x] = new Ledge(x_pos, 490f - (interval *x) - height, (float) (Math.random() * 3), 0f);
	   	   	 }
	   	   	 else {
	   	   	     level[x] = new Ledge(x_pos, 490f - (interval *x) - height, 0f, 0f);
	   	   	 }
		}
	}
	//moves ledges at cam speed, and triggers new level generation if needed
	public static void updateLevel(Ledge[] level1, Ledge[] level2, float cam_speed) {
		if (level1[5].y_pos < 500) {
			for(Ledge ledge : level1) {
				ledge.update(cam_speed);
			}
		}
		else {
			generateLevel(level1, 500);
		}
		if(level2[5].y_pos<500) {
			for(Ledge ledge : level2) {
				ledge.update(cam_speed);
			}
		}
		else {
			generateLevel(level2, 500);
		}
	}
	//displays all ledges
	public static void displayLevel(Ledge[] level1,Ledge[] level2, Game game) {
		for(Ledge ledge : level1) {
			ledge.display(game);
		}
		for(Ledge ledge : level2) {
			ledge.display(game);
		}
	}
	
	//Detecting when the game is over
	public static boolean isGameOver(Player player){
		
		if ((player.x_pos >= 0f && player.x_pos <= 400f) && player.y_pos >= 500f){
			return true;
		}
		
		return false;
	}		
}
