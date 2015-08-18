package br.com.andreramosdev.bis14.control;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGPoint;

import br.com.andreramosdev.bis14.interfaces.ButtonDelegate;
import br.com.andreramosdev.bis14.scenes.GameScene;

import static br.com.andreramosdev.bis14.config.Assets.LEFTCONTROL;
import static br.com.andreramosdev.bis14.config.Assets.RIGHTBUTTON;
import static br.com.andreramosdev.bis14.config.Assets.SHOOTBUTTON;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenResolution;
import static br.com.andreramosdev.bis14.config.DeviceSettings.screenWidth;

/**
 * Created by andre on 13/08/15.
 */
public class GameButtons extends CCLayer implements ButtonDelegate {
    private Button leftControl;
    private Button rightControl;
    private Button shootButton;
    private GameScene delegate;

    public static GameButtons gameButtons() {
        return new GameButtons();
    }

    public GameButtons() {
        //Habilita o toque na tela
        this.setIsTouchEnabled(true);

        //Cria os botões
        this.leftControl = new Button(LEFTCONTROL);
        this.rightControl = new Button(RIGHTBUTTON);
        this.shootButton = new Button(SHOOTBUTTON);

        // Configura as delegações
        this.leftControl.setDelegate(this);
        this.rightControl.setDelegate(this);
        this.shootButton.setDelegate(this);

        //Configura posições
        setButtonspPosition();

        //Adiciona os botões na tela
        addChild(leftControl);
        addChild(rightControl);
        addChild(shootButton);
    }

    @Override
    public void buttonClicked(Button sender) {
        if(sender.equals(this.leftControl)) {
            System.out.println("LEFT");
        }
        if(sender.equals(this.rightControl)) {
            System.out.println("RIGHT");
        }
        if(sender.equals(this.shootButton)) {
            System.out.println("SHOOT");
        }
        if(sender.equals(this.shootButton)) {
            this.delegate.shoot();
        }
    }

    public void setDelegate(GameScene gameScene) {
        this.delegate = gameScene;
    }

    private void setButtonspPosition() {
        leftControl.setPosition(screenResolution(CGPoint.ccp(40, 40)));
        rightControl.setPosition(screenResolution(CGPoint.ccp(100, 40)));
        shootButton.setPosition(screenResolution(CGPoint.ccp(screenWidth() - 40, 40)));
    }
}
