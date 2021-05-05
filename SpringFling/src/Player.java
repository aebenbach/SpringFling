public class Player {
    public float x_speed;
    public float y_speed;
    public float x_pos;
    public float y_pos;
    boolean status = false;
    boolean direction_l = false;
      
    public Player() {
   	 this(200,500,0,-8);
    }
    public Player(float x_pos, float y_pos, float x_speed, float y_speed) {
   	 this.x_pos = x_pos;
   	 this.y_pos = y_pos;
   	 this.x_speed = x_speed;
   	 this.y_speed = y_speed;
    }
    //adjust player horizontal speed according to what buttons are pressed at the time
    public void resolveX(boolean left_pressed,boolean right_pressed) {
   	 if (right_pressed == left_pressed) {
   		 this.x_speed = 0f;
   	 }
   	 else if (right_pressed) {
   		 this.x_speed = 4f;
   		 direction_l = false;
   		 
   	 }
   	 else {
   		 this.x_speed = -4f;
   		 direction_l = true;
   	 }
    }
    
//updates y and x position of player according to player speed and cam speed
    public void update(float cam_speed) {
   	 if (this.x_pos > 400) {
   		 this.x_pos = 1;
   	 }
   	 if (this.x_pos < 1) {
   		 this.x_pos = 400;
   	 }
   	 this.x_pos += this.x_speed;
   	 this.y_pos += (this.y_speed+cam_speed);
   	 
   	 if (this.y_pos >= 500) {
   		 status = true;
   	 }
    }
    
    //determine if the game is over based on whether you fell off the bottom of the screen
    public boolean playerStatus() {
   	 return status;
    }
    
  //displays player as the bunny
    public void display(Game game) {
   	 if (direction_l) {
   		 game.printImage("character_r_img",this.x_pos, this.y_pos-10.0f, 20.0f,20.0f);
   	 }
   	 else {
   		 game.printImage("character_img",this.x_pos, this.y_pos-10.0f, 20.0f,20.0f);
   	 }
    }
}
