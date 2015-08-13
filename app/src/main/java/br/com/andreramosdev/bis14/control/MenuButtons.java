package br.com.andreramosdev.bis14.control;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;

import br.com.andreramosdev.bis14.config.Assets;
import br.com.andreramosdev.bis14.interfaces.ButtonDelegate;
import br.com.andreramosdev.bis14.scenes.GameScene;

import static br.com.andreramosdev.bis14.config.DeviceSettings.screenHeigth;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenResolution;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenWidth;

/**
 * Created by andre on 11/08/15.
 */
public class MenuButtons extends CCLayer implements ButtonDelegate {
    private Button playButton;
    private Button highscoreButton;
    private Button helpButton;
    private Button soundButton;

    public MenuButtons () {
        this.setIsTouchEnabled(true);

        this.playButton = new Button(Assets.PLAY);
        this.highscoreButton = new Button(Assets.HIGHSCORE);
        this.helpButton = new Button(Assets.HELP);
        this.soundButton = new Button(Assets.SOUND);

        this.playButton.setDelegate(this);
        this.highscoreButton.setDelegate(this);
        this.helpButton.setDelegate(this);
        this.soundButton.setDelegate(this);

        setButtonspPosition();

        addChild(playButton);
        addChild(highscoreButton);
        addChild(helpButton);
        addChild(soundButton);
    }

    private void setButtonspPosition() {
        playButton.setPosition(screenResolution(CGPoint.ccp(
                screenWidth() / 2,
                screenHeigth() - 250
        )));

        highscoreButton.setPosition(screenResolution(CGPoint.ccp(
                screenWidth() / 2,
                screenHeigth() - 300
        )));

        helpButton.setPosition(screenResolution(CGPoint.ccp(
                screenWidth() / 2,
                screenHeigth() - 350
        )));

        soundButton.setPosition(screenResolution(CGPoint.ccp(
                screenWidth() / 2 - 100,
                screenHeigth() - 420
        )));
    }

    @Override
    public void buttonClicked(Button sender) {
        if (sender.equals(this.playButton)) {
            System.out.println("Play");
            CCDirector.sharedDirector().replaceScene(
                    CCFadeTransition.transition(1.0f, GameScene.createGame())
            );
        }

        if (sender.equals(this.helpButton)) {
            System.out.println("Help");
        }

        if (sender.equals(this.highscoreButton)) {
            System.out.println("Highscore");
        }

        if (sender.equals(this.soundButton)) {
            System.out.println("Sound");
        }
    }
}
