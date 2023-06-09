package ru.myitschool.knightoflight;

import static ru.myitschool.knightoflight.MyGG.SCR_HEIGHT;
import static ru.myitschool.knightoflight.MyGG.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenAbout implements Screen {
    MyGG gg;
    Texture imgBG;
    TextButton btnBack;
    String textAbout =  "Это игра о добром воине\n" +
                        "создана в IT-школе Samsung\n" +
                        "которая будет интересна напротяжении \n" +
                        "всего путешествия";

    public ScreenAbout(MyGG myGG){
        gg = myGG;
        btnBack = new TextButton(gg.fontLarge, "BACK", 220, 100);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
// обработка касаний
        if(Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            if(btnBack.hit(gg.touch.x, gg.touch.y)){
                gg.setScreen(gg.screenIntro);
            }
        }

        // отрисовка графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        gg.fontSmall.draw(gg.batch, textAbout, 50, 900);
        btnBack.font.draw(gg.batch, btnBack.text, btnBack.x, btnBack.y);
        gg.batch.end();
    }

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
    public void dispose(){

    }
}
