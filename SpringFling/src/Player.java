
public class Player {
	public float x_speed;
	public float y_speed;
	public float x_pos;
	public float y_pos;
	  
	public Player() {
		this(200,500,0,-8);
	}
	public Player(float x_pos, float y_pos, float x_speed, float y_speed) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.x_speed = x_speed;
		this.y_speed = y_speed;
	}
	public void resolveX(boolean left_pressed,boolean right_pressed) {
		if (right_pressed == left_pressed) {
			this.x_speed = 0f;
		}
		else if (right_pressed) {
			this.x_speed = 4f;
		}
		else {
			this.x_speed = -4f;
		}
	}
	public void update(float cam_speed) {
		if (this.x_pos > 400) {
			this.x_pos = 1;
		}
		if (this.x_pos < 1) {
			this.x_pos = 400;
		}
		this.x_pos += this.x_speed;
		this.y_pos += (this.y_speed+cam_speed);
	}
	public void display(Game game) {
		game.fill(255,0,0);
		game.ellipse(this.x_pos, this.y_pos-10.0f, 20.0f,20.0f);
	}
}
