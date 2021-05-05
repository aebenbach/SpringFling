/* I made this ledge class only as a placeholder, so it still needs improvements like movement, etc. */
public class Ledge {
	public float x_speed;
	public float y_speed;
	public float x_pos;
	public float y_pos;
	
	public Ledge() {
		this(200,250,0,0);
	}
	
	public Ledge(float x_pos, float y_pos, float x_speed,float y_speed) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.x_speed = x_speed;
	}
	//updates ledges position to account for cam movement
	public void update(float cam_speed) {
		this.y_pos += (y_speed + cam_speed);
		this.x_pos += x_speed;
	}
	//displays ledge. Important detail here, the game object has to be passed because drawing methods 
	//in processing are non-static
	public void display(Game game) {
		game.rect(x_pos, y_pos, 25, 10);
	}
}
/*
//FINAL
public class Ledge {
	public float x_speed;
	public float y_speed;
	public float x_pos;
	public float y_pos;
	
	public Ledge() {
		this(200,250,0,0);
	}
	
	public Ledge(float x_pos, float y_pos, float x_speed,float y_speed) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.x_speed = x_speed;
	}
	//updates ledges position to account for cam movement
	public void update(float cam_speed) {
		this.y_pos += (y_speed + cam_speed);
		this.x_pos += x_speed;
		if (this.x_pos >= 400 || this.x_pos <= 0){
	           this.x_speed = -this.x_speed;
	         }
	}
	//displays ledge. Important detail here, the game object has to be passed because drawing methods 
	//in processing are non-static
	public void display(Game game) {
	   	 game.printImage("ledge_img", x_pos, y_pos, 25, 10);
	}
}
*/
