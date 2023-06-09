package ru.myitschool.knightoflight;


import static ru.myitschool.knightoflight.MyGG.SCR_HEIGHT;
import static ru.myitschool.knightoflight.MyGG.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenSettings implements Screen {
    MyGG gg;
    Texture imgBG;
    TextButton btnEnterName, btnSound, btnMusic, btnClearTable, btnBack;
    boolean enterPlayerName;
    InputKeyboard keyboard;
    String playerName = "Noname";

    public ScreenSettings(MyGG myGG){
        gg = myGG;
        btnEnterName = new TextButton(gg.fontLarge, "NAME: "+playerName, 100, 600);
        btnSound = new TextButton(gg.fontLarge, "SOUND ON", 100, 500);
        btnMusic = new TextButton(gg.fontLarge, "MUSIC ON", 100, 400);
        btnClearTable = new TextButton(gg.fontLarge, "CLEAR RECORDS", 100, 300);
        btnBack = new TextButton(gg.fontLarge, "BACK", 100, 200);



        keyboard = new InputKeyboard(SCR_WIDTH, SCR_HEIGHT/2f, 7);
        loadSettings();
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
            if(enterPlayerName) {
                if(keyboard.endOfEdit(gg.touch.x, gg.touch.y)) {
                    enterPlayerName = false;
                    playerName = keyboard.getText();
                    updateButtons();
                }
            } else {
                if (btnEnterName.hit(gg.touch.x, gg.touch.y)) {
                    enterPlayerName = true;
                }
                if (btnSound.hit(gg.touch.x, gg.touch.y)) {
                    gg.soundOn = !gg.soundOn;
                    updateButtons();
                }
                if (btnMusic.hit(gg.touch.x, gg.touch.y)) {
                    gg.musicOn = !gg.musicOn;
                    updateButtons();
                }
                if(btnClearTable.hit(gg.touch.x, gg.touch.y)){
                    btnClearTable.text = "RECORDS CLEARED";
                }
                if (btnBack.hit(gg.touch.x, gg.touch.y)) {
                    gg.setScreen(gg.screenIntro);
                    btnClearTable.text = "CLEAR RECORDS";
                }
            }
        }

        // игровые события

        // отрисовка графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnEnterName.font.draw(gg.batch, btnEnterName.text, btnEnterName.x, btnEnterName.y);
        btnSound.font.draw(gg.batch, btnSound.text, btnSound.x, btnSound.y);
        btnMusic.font.draw(gg.batch, btnMusic.text, btnMusic.x, btnMusic.y);
        btnClearTable.font.draw(gg.batch, btnClearTable.text, btnClearTable.x, btnClearTable.y);
        btnBack.font.draw(gg.batch, btnBack.text, btnBack.x, btnBack.y);
        if(enterPlayerName){
            keyboard.draw(gg.batch);
        }
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
        saveSettings();
    }

    @Override
    public void dispose() {
        imgBG.dispose();
        keyboard.dispose();
    }

    void saveSettings() {
        Preferences pref = Gdx.app.getPreferences("settings");
        pref.putString("name", playerName);
        pref.putBoolean("sound", gg.soundOn);
        pref.putBoolean("music", gg.musicOn);
        pref.flush();
    }

    void loadSettings() {
        Preferences pref = Gdx.app.getPreferences("settings");
        if(pref.contains("name")) playerName = pref.getString("name");
        if(pref.contains("sound")) gg.soundOn = pref.getBoolean("sound");
        if(pref.contains("music")) gg.musicOn = pref.getBoolean("music");
        updateButtons();
    }

    void updateButtons(){
        btnEnterName.setText("NAME: "+playerName);
        btnSound.setText(gg.soundOn ? "SOUND ON" : "SOUND OFF");
        btnMusic.setText(gg.musicOn ? "MUSIC ON" : "MUSIC OFF");
    }
}
