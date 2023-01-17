//
//
//package com.mygdx.game.Screen;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.maps.tiled.TiledMap;
//import com.badlogic.gdx.maps.tiled.TmxMapLoader;
//import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.badlogic.gdx.utils.viewport.StretchViewport;
//import com.badlogic.gdx.utils.viewport.Viewport;
//import com.mygdx.game.MyGdxGame;
//import com.mygdx.game.Player;
//
//import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
//
//public class PlayGame implements Screen {
//	private MyGdxGame game;
//	private OrthographicCamera gamecam;
//	private Viewport gamePort;
//	private Stage stage;
//	private Texture texture1,texture2,texture3,texture4;
//	private TextureRegion region;
//	private Image tank1_image,tank2_image,tank3_image,choose_image;
//	private TmxMapLoader mapLoader;
//	private TiledMap map;
//	private OrthogonalTiledMapRenderer renderer;
//	private Player player;
//	private int i=0;
//
//	public PlayGame(MyGdxGame game,Player player1,Player player2) {
//		this.game = game;
//		i = 0;
//		texture1 = new Texture("tank1.png");
//		tank1_image = new Image(texture1);
//		texture2 = new Texture("tank2.png");
//		tank2_image = new Image(texture2);
//		texture3 = new Texture("tank3.png");
//		tank3_image = new Image(texture3);
//		texture4 = new Texture("Choose.png");
//		choose_image = new Image(texture4);
//
//		region = new TextureRegion(texture1, 0, 0, 32, 32);
//		gamecam = new OrthographicCamera();
//		gamePort = new StretchViewport(1200, 675, gamecam);
//		stage = new Stage(gamePort);
//
//		tank1_image.setPosition(0, 0);
//		tank2_image.setPosition(0, 0);
//		tank3_image.setPosition(0, 0);
//
//		stage.addActor(tank3_image);
//		stage.addActor(tank2_image);
//		stage.addActor(tank1_image);
//		stage.addActor(choose_image);
//
//		tank1_image.addListener(new ClickListener() {
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				i = 1;
//				System.out.println("tank1");
//			}
//		});
//		tank2_image.addListener(new ClickListener() {
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				i = 2;
//				System.out.println("tank2");
//			}
//		});
//		tank3_image.addListener(new ClickListener() {
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				i = 3;
//				System.out.println("tank3");
//			}
//		});
//
//		mapLoader = new TmxMapLoader();
//		map = mapLoader.load("tile_background.tmx");
//		renderer = new OrthogonalTiledMapRenderer(map);
//		gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
//	}
//
//public void handleInput(float dt) {
//		if (Gdx.input.isTouched()) {
//			gamecam.position.x += 1000 * dt;
//		}
//	}
//
//	public void update(float dt) {
//		handleInput(dt);
//		gamecam.update();
//		renderer.setView(gamecam);
//	}
//
//	@Override
//	public void render(float delta) {
//		update(delta);
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		renderer.render();
//		stage.act();
//		stage.draw();
//	}
//
//	@Override
//	public void resize(int width, int height) {
//		gamePort.update(width, height);
//	}
//
//	@Override
//	public void dispose() {
//		map.dispose();
//		renderer.dispose();
//		stage.dispose();
//	}
//
//	@Override
//	public void show() {
//	}
//
//	@Override
//	public void hide() {
//	}
//
//	@Override
//	public void pause() {
//	}
//
//	@Override
//	public void resume() {
//	}
//}
//
package com.mygdx.game.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.Input.Keys;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Player;
import com.mygdx.game.Tank;

import javax.swing.*;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class PlayGame implements Screen {
	private PlayGame previousScreen;

	private Tank runns1;
	private Tank runns2;
	private World world;
	private Box2DDebugRenderer bxrend;
	MyGdxGame game;
	int p1_id, p2_id;
	private Texture texture1, texture2, texture3, texture4, texture5;
	private TextureRegion region;
	private Choose_Tank tank_p1, tank_p2;

	private OrthographicCamera gamecam;
	private Stage stage;

	private Viewport gamePort;

	private Image sky_image, pause_image, tank1_image, tank2_image, ground_image,circle1,circle2,circlr3,circlr4,circle5;
	private TmxMapLoader load_map;
	private TiledMap tiled_map;
	private OrthogonalTiledMapRenderer render_tile;
	private Player player1, player2;
	private int turn=1,count=0;
	double angle1=45;
	double angle2=45;



	public PlayGame(MyGdxGame game, Player player1, Player player2) {
		this.game = game;

		this.p1_id = player1.getTank_ID();
		this.p2_id = player2.getTank_ID();
		this.player1 = player1;
		this.player2 = player2;
		load_map = new TmxMapLoader();
		System.out.println("PlayGame created");
		tiled_map = load_map.load("tilekyalikhe.tmx");
		System.out.println("load_map created");
		render_tile = new OrthogonalTiledMapRenderer(tiled_map);
		System.out.println("tiled_map created");
		gamecam = new OrthographicCamera();
		gamecam.setToOrtho(false, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		world = new World(new Vector2(0, -10), true);
		bxrend = new Box2DDebugRenderer();
		BodyDef def_b = new BodyDef();
		PolygonShape figure = new PolygonShape();
		FixtureDef fix = new FixtureDef();
		Body whole;
		runns1= new Tank(world,1,stage);
		runns2= new Tank(world,2,stage);

		for (MapObject item: tiled_map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle shape_obj = ((RectangleMapObject) item).getRectangle();
			def_b.type = BodyDef.BodyType.StaticBody;
			def_b.position.set((shape_obj.getX()+shape_obj.getWidth()/2), (shape_obj.getY()+shape_obj.getHeight()/2));
//			System.out.printf("%f\n",def_b.position.x);
			whole=world.createBody(def_b);
			figure.setAsBox((shape_obj.getWidth()/2), (shape_obj.getHeight()/2));
			fix.shape=figure;
			whole.createFixture(fix);

		}

		texture2 = new Texture("pause.png");
		pause_image = new Image(texture2);
		System.out.println("PlayGame created");


		texture3 = new Texture("T1.png");
		tank1_image = new Image(texture3);
		tank1_image.setSize(tank1_image.getWidth() / 4, tank1_image.getHeight() / 4);
//		gamePort = new StretchViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
		gamePort = new StretchViewport(1150,630, gamecam);

		gamecam.setToOrtho(false, 1200, 630);
		gamecam.position.set(gamePort.getWorldWidth(), gamePort.getWorldHeight(), 0);

		gamecam.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2, 0);

		stage = new Stage(gamePort);
		pause_image.setScale(0.25f);
		pause_image.setPosition(gamePort.getWorldWidth(), (float) (gamePort.getWorldHeight() - 0.25 * pause_image.getHeight()));
		System.out.printf("THIS IS PLAYGAME CONSTRUCTOR");
	}

//	public void PlayGame(MyGdxGame game, int tank1id, int tank2id) {
//		this.p1_id = tank1id;
//		this.p2_id = tank2id;
//		this.game = game;
//		System.out.println("\nPLAYGAME RESUME CONSTRUCTOR ");
//		game.setScreen(new PlayGame(game, new Player(tank1id), new Player(tank2id)));
//
////		game.setScreen(new PlayGame(game, new Player(tank1id), new Player(tank2id)));
////		new PlayGame(game, new Player(tank1id), new Player(tank2id));
//		System.out.println("PLAYGAME RESUME CONSTRUCTOR ENDED\n");
//		return;
//
////		texture1 = new Texture("sky1.jpeg");
////		sky_image = new Image(texture1);
////
////		texture2 = new Texture("pause.png");
////		pause_image = new Image(texture2);
////
//////		System.out.println("PlayGame created");
////
////		texture3 = new Texture("T1.png");
////		tank1_image = new Image(texture3);
//////		System.out.println("PlayGame created");
//////
//////		texture4 = new Texture("T2.jpg");
//////		tank2_image = new Image(texture4);
////
//////		texture5 = new Texture("gnd.png");
//////		ground_image = new Image(texture5);
//////		ground_image.setSize(texture1.getWidth(), texture1.getHeight()/1.5f);
////
////		region = new TextureRegion(texture1, 0, 0, 32, 32);
////		gamecam = new OrthographicCamera();
////		gamePort = new StretchViewport(910,512, gamecam);
////		stage = new Stage(gamePort);
////
//////		tank1_image.setPosition(160,160);
//////		sky_image.setPosition(0,0);
//////		ground_image.setPosition(0,0);
////		tank1_image.setPosition(160,160);
////		System.out.println("x: "+tank1_image.getX()+" y: "+tank1_image.getY());
////		pause_image.setScale(0.25f);
////		pause_image.setPosition(gamePort.getWorldWidth() - 50, (float) (gamePort.getWorldHeight() - 0.25*pause_image.getHeight()));
////		System.out.printf("THIS IS PLAYGAME CONSTRUCTOR");
//
//	}


	@Override
	public void show() {
		render_tile.setView(gamecam);
		Gdx.input.setInputProcessor(stage);
		render_tile.render();

//		stage.addActor(sky_image);
//		System.out.printf("X: %f Y: %f",tank1_image.getX(),tank1_image.getY());
//		sky_image.addAction(sequence(alpha(0), fadeIn(2f)));
//		sky_image.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("CLICKED ON SKY");
////				game.setScreen(new PlayGame(game));
////				dispose();
//			}
//		});
//
//		stage.addActor(ground_image);
//		ground_image.addAction(sequence(alpha(0), fadeIn(2f)));
//		ground_image.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("CLICKED ON GROUND");
////				game.setScreen(new PlayGame(game));
////				dispose();
//			}
//		});
		if (p1_id==1) {
			texture3 = new Texture("T1.png");
			tank1_image = new Image(texture3);
			runns1.setTankimage(texture3);
			runns1.setTankimage2(tank1_image);
			tank1_image.setSize(tank1_image.getWidth() / 4, tank1_image.getHeight() / 4);
			tank1_image.setPosition((int)runns1.getFig().getPosition().x, (int)runns1.getFig().getPosition().y);
			stage.addActor(tank1_image);
			tank1_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		else if (p1_id==2) {
			texture3 = new Texture("T2.png");
			runns1.setTankimage(texture3);
			tank1_image = new Image(texture3);
			runns1.setTankimage2(tank1_image);
			tank1_image.setSize(tank1_image.getWidth() / 4, tank1_image.getHeight() / 4);
			tank1_image.setPosition(50, 122);
			stage.addActor(tank1_image);
			tank1_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		else if (p1_id==3) {
			texture3 = new Texture("T3.png");
			tank1_image = new Image(texture3);
			runns1.setTankimage(texture3);
			runns1.setTankimage2(tank1_image);
			tank1_image.setSize(tank1_image.getWidth() / 4, tank1_image.getHeight() / 4);
			tank1_image.setPosition(50, 140);
			stage.addActor(tank1_image);
			tank1_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}

		if (p2_id==1) {
			texture4 = new Texture("T1R.png");
			tank2_image = new Image(texture4);
			runns2.setTankimage(texture4);
			runns2.setTankimage2(tank2_image);
			tank2_image.setSize(tank2_image.getWidth() / 4, tank2_image.getHeight() / 4);
			tank2_image.setPosition(gamePort.getWorldWidth()-250, gamePort.getWorldHeight()-350);
			stage.addActor(tank2_image);
			tank2_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		else if (p2_id==2) {
			texture4 = new Texture("T2R.png");
			tank2_image = new Image(texture4);
			runns2.setTankimage(texture4);
			runns2.setTankimage2(tank2_image);
			tank2_image.setSize(tank2_image.getWidth() / 4, tank2_image.getHeight() / 4);
			tank2_image.setPosition(gamePort.getWorldWidth()-250, gamePort.getWorldHeight()-363);
			stage.addActor(tank2_image);
			tank2_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		else if (p2_id==3) {
			texture4 = new Texture("T3R.png");
			tank2_image = new Image(texture4);
			runns2.setTankimage2(tank2_image);
			runns2.setTankimage(texture4);
			runns2.setTankimage2(tank2_image);
			tank2_image.setSize(tank2_image.getWidth() / 4, tank2_image.getHeight() / 4);
			tank2_image.setPosition(gamePort.getWorldWidth()-250, gamePort.getWorldHeight()-350);
			stage.addActor(tank2_image);
			tank2_image.addAction(sequence(alpha(0), fadeIn(2f)));
		}
		stage.addActor(tank1_image);
		tank1_image.addAction(sequence(alpha(0), fadeIn(2f)));

		stage.addActor(pause_image);
		pause_image.addAction(sequence(alpha(0), fadeIn(2f)));
		pause_image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pause_it();
			}
		});
	}
	private void pause_it(){
		System.out.printf("CLICKED ON PAUSE");
//		game.dispose();
		tank1_image.remove();
		tank2_image.remove();
//		stage.dispose();
		game.setScreen((Screen) new Pause_Screen(game,player1,player2,this));
	}

	void turn1(){
		if (count == 2){
			if ((runns1.getTank_b().getPosition().x-(tank1_image.getWidth()/8))<=runns2.getBullet().getPosition().x && count == 2){
//				runns2.getUniverse().destroyBody(runns2.getBullet());
//				runns2.getBombimage().remove();
				runns1.setHealth(runns1.getHealth() - 20);
				count=1;
			}
		}

		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			//SHOOT A BALL AT 90 DEGREES
			count=1;
			runns1.getTank_b().setLinearVelocity(0, -10);
			runns2.getTank_b().setLinearVelocity(0,-10);
			System.out.printf("Angle is %f\n",runns1.getTank_b().getAngle());
			runns1.shoot(angle1,stage,1);
			System.out.printf("turn of 2\n");
			this.turn=0;
			runns2.setFuel(200);
			return;
		}
		else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if(runns1.getFuel()>0) {
				runns1.getTank_b().setLinearVelocity(60, -10);
				runns2.getTank_b().setLinearVelocity(0, -100);
				runns1.setFuel(runns1.getFuel() - 1);
			}
			else{
                runns1.getTank_b().setLinearVelocity(0, -100);
                runns2.getTank_b().setLinearVelocity(0, -100);
            }
		} else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			if(runns1.getFuel()>0) {
				runns1.getTank_b().setLinearVelocity(-60, -10);
				runns2.getTank_b().setLinearVelocity(0, -100);
				runns1.setFuel(runns1.getFuel() - 1);
			}
			else{
                runns1.getTank_b().setLinearVelocity(0, -100);
                runns2.getTank_b().setLinearVelocity(0, -100);
            }
		}else if (Gdx.input.isKeyPressed(Keys.UP)) {
			angle1 += 1;
			if (angle1 > 90) {
				angle1 = 90;
			}
				System.out.println("ANGLE OF TANK 1 IS " + angle1);
		}
		else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			angle1 -= 1;
			if (angle1 < 0) {
				angle1 = 0;
			}
			System.out.println("ANGLE OF TANK 1 IS "+angle1);
		}
		else {
			runns1.getTank_b().setLinearVelocity(0, -100);
			runns2.getTank_b().setLinearVelocity(0, -100);
		}

        }


	void turn2(){
		if ((runns2.getTank_b().getPosition().x-(tank1_image.getWidth()/8))<=runns1.getBullet().getPosition().x && count == 1){
			runns1.getUniverse().destroyBody(runns1.getBullet());
			runns1.getBombimage().remove();
            runns2.setHealth(runns2.getHealth() - 20);
			count=2;
		}
		if (Gdx.input.isKeyPressed(Keys.F)) {
				count=2;
				runns1.getTank_b().setLinearVelocity(0, -10);
				runns2.getTank_b().setLinearVelocity(0, -10);
				runns2.shoot(angle2, stage, 2);
				System.out.printf("turn of 1\n");
				this.turn = 1;
				runns1.setFuel(150);
				return;
		}
		else if (Gdx.input.isKeyPressed(Keys.D)) {
			if(runns2.getFuel()>0) {
				runns1.getTank_b().setLinearVelocity(0, -100);
				runns2.getTank_b().setLinearVelocity(60, -10);
				runns2.setFuel(runns2.getFuel() - 1);
			}
			else{
                runns1.getTank_b().setLinearVelocity(0, -100);
                runns2.getTank_b().setLinearVelocity(0, -100);
            }
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			if(runns2.getFuel()>0) {
				runns1.getTank_b().setLinearVelocity(0, -100);
				runns2.getTank_b().setLinearVelocity(-60, -10);
				runns2.setFuel(runns2.getFuel() - 1);
			}
			else{
                runns1.getTank_b().setLinearVelocity(0, -100);
                runns2.getTank_b().setLinearVelocity(0, -100);
            }
		}else if(Gdx.input.isKeyPressed(Keys.W)) {
			angle2 += 1;
			if (angle2 > 90) {
				angle2 = 90;
			}
			System.out.println("ANGLE OF TANK 2 IS"+angle2);
		}
		else if (Gdx.input.isKeyPressed(Keys.S)) {
			angle2 -= 1;
			if (angle2 < 0) {
				angle2 = 0;
			}
			System.out.println("ANGLE OF TANK 2 IS " + angle2);
		}
		else {
			runns1.getTank_b().setLinearVelocity(0, -100);
			runns2.getTank_b().setLinearVelocity(0, -100);
        }
	}

	public void input(float dt){
		if (turn==1) {
			turn1();
		}
		else {
			turn2();
		}
	}

	@Override
	public void render(float delta) {
		update(delta);
		tank1_image.setPosition((int)runns1.getTank_b().getPosition().x-(tank1_image.getWidth()/2), (int)runns1.getTank_b().getPosition().y-(tank1_image.getHeight()/4));
		tank2_image.setPosition((int)runns2.getTank_b().getPosition().x-(tank2_image.getWidth()/2), (int)runns2.getTank_b().getPosition().y-(tank2_image.getHeight()/4));
		if (runns1.getBombimage()!=null) {
			runns1.getBombimage().setPosition((int) runns1.getBullet().getPosition().x - (runns1.getBombimage().getWidth() / 2), (int) runns1.getBullet().getPosition().y - (runns1.getBombimage().getHeight() / 4));
		}
		if (runns2.getBombimage()!=null) {
            runns2.getBombimage().setPosition((int) runns2.getBullet().getPosition().x - (runns2.getBombimage().getWidth() / 2), (int) runns2.getBullet().getPosition().y - (runns2.getBombimage().getHeight() / 4));
        }
//		System.out.printf("");
//		System.out.printf("%f %f\n",runns1.fig.getPosition().x,runns1.fig.getPosition().y);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		bxrend.render(world,gamecam.combined);
//		System.out.printf("%f %f\n",tank1_image.getImageX(),tank1_image.getImageY());
//		tank1_image.setPosition((int)runns1.fig.getPosition().x, (int)runns1.fig.getPosition().y);
//		render_tile.render();

		gamecam.update();

		game.batch.setProjectionMatrix(gamecam.combined);

		game.batch.begin();
		game.font.draw(game.batch,"TANK 1 FUEL : "+runns1.getFuel(),20,580);
		game.font.draw(game.batch,"TANK 1 HEALTH : "+runns1.getHealth(),20,560);
		game.font.draw(game.batch,"TANK 1 Controls : \n LEFT,RIGHT : Move \n UP , DOWN :Set angle \n SPACE : SHOOT",20,520);
		game.font.draw(game.batch,"TANK 2 Controls : \n A,D : Move \n W , S : Set angle \n F : SHOOT",1000,520);

		game.font.draw(game.batch,"TANK 2 FUEL : "+runns2.getFuel(),1000,580);
		game.font.draw(game.batch,"TANK 2 HEALTH : "+runns2.getHealth(),1000,560);

		render_tile.render();


		game.batch.end();


		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

	}

	public void update(float delta) {
		input(delta);
		world.step(1/60f,6,2);
		gamecam.update();
		render_tile.setView(gamecam);
		stage.act(delta);
//		stage.act(delta);
	}

	@Override
	public void resize(int width, int height) {

		gamecam.viewportWidth=width;
		gamecam.viewportHeight=height;
		gamecam.position.set(width/2f,height/2f,0);
		gamecam.update();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
}
