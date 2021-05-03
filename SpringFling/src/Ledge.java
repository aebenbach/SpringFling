
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
	public void update(float cam_speed) {
		this.y_pos += (y_speed + cam_speed);
	}
	public void display(Game game) {
		game.rect(x_pos, y_pos, 25, 10);
	}
}
