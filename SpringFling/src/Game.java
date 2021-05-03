import processing.core.*; 

public class Game extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Game");
		
	}
	
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
		
		level1 = new Ledge[6];
		level2 = new Ledge[6];
		generateLevel(level1,0);
		generateLevel(level2, 500);
	}
	public void keyPressed() {

		if (key == 'a') {
			left_pressed = true;
		}
		if (key == 'd') {
			right_pressed = true;
		}
	}
	public void keyReleased() {

		if (key == 'a') {
			left_pressed = false;
		}
		if (key == 'd'){
			right_pressed = false;
		}
	}
	public void draw() {

		player.resolveX(left_pressed,right_pressed);
		if (isLanded(player, level1,level2)) {
			player.y_speed = -9f;
		}
		else if (player.y_speed < 8f){
			player.y_speed += .20f;
		}
		
		if (player.y_pos < 250f && player.y_speed < 0f) {
			cam_speed = player.y_speed * -1;
		}
		else {
			cam_speed = 0f;
		}
		score += cam_speed;
		background(0);
		updateLevel(level1,level2,cam_speed);
		displayLevel(level1,level2,this);
		player.update(cam_speed);
		player.display(this);
	}
	
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
	public static void generateLevel(Ledge[] level, float height) {
		float interval = (500 / level.length);
		for(int x=0; x < level.length ; x++) {
			float x_pos = (float)(Math.random() * 376);
			level[x] = new Ledge(x_pos, 490f - (interval *x) - height, 0f, 0f);
		}
	}
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
	public static void displayLevel(Ledge[] level1,Ledge[] level2, Game game) {
		for(Ledge ledge : level1) {
			ledge.display(game);
		}
		for(Ledge ledge : level2) {
			ledge.display(game);
		}
	}
}
