package ru.myitschool.knightoflight;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

public class ScreenGame implements Screen {
    MyGG gg;

    boolean isAccelerometerPresent;
    //boolean isGyroscopePresent;

    Texture imgStars;
    Texture imgShip;
    Texture imgEnemy;
    Texture imgShot;
    Texture imgFragmentEnemy, imgFragmentShip;
    Sound sndShot;
    Sound sndExplosion;


    long timeEnemyLastSpawn, timeEnemySpawnInterval = 1100;
    long timeShotLastSpawn, timeShotSpawnInterval = 500;

    public ScreenGame(MyGG myGG) {
        gg = myGG;

        isAccelerometerPresent = Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer);
        //isGyroscopePresent = Gdx.input.isPeripheralAvailable(Input.Peripheral.Gyroscope);

        imgStars = new Texture("stars.png");
        imgShip = new Texture("ship.png");
        imgEnemy = new Texture("enemy.png");
        imgShot = new Texture("shot.png");




    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // обработка касаний

        } /*else if(isGyroscopePresent) {
            ship.vx = Gdx.input.getGyroscopeY()*10;
        }*/

        // события игры



        // отрисовка графики


    @Override
    public void resize(int width, int height) {

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
        imgStars.dispose();
        imgShip.dispose();
        imgShot.dispose();
        imgFragmentEnemy.dispose();
        imgFragmentShip.dispose();
        sndShot.dispose();
        sndExplosion.dispose();
    }



        }


