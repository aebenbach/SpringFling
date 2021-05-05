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
// This is the public class ledge I made
public class Ledge{
  //Ledge Width and Height are constants
  public color Color;
  private final int ledgeWidth  = 50;
  private final int ledgeHeight = 7;
  public float xPos;
  public float yPos;
  public float xSpeed;
  public final float pixelShift = 5; //TBD this will change!
  
  //Constructor initializes a white static ledge
  public Ledge(){
    this(color(255,255,255),50,425,0);
  }
  
  //Constructor initializes starting ledges
  public Ledge(color Color, float tempXPos, float tempYPos, float tempXSpeed){
    this.Color = Color;
    this.xPos = tempXPos;
    this.yPos = tempYPos;
    this.xSpeed = tempXSpeed;
  }
  
  //Used to make the game harder
  public void updateSpeed(){
    this.xSpeed += 1;
  }
  
  //Constructor initializes a static ledge
  public void display(Game game){
    game.fill(Color);
    game.stroke(0);
    game.rectMode(CENTER);
    game.rect(this.xPos,this.yPos,ledgeWidth,ledgeHeight);
  }
  
  //Moving ledge from left to right!
  public void move(){ //Check if Game game needs to be added here or nah!
     this.xPos += this.xSpeed; 
      if (this.xPos >= width || this.xPos <= 0){
        this.xSpeed = -this.xSpeed;
      }
  }
  
  //Method that moves screen up
  public void update(){
    this.yPos += this.pixelShift;
  }
}
*/