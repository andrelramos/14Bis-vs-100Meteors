package br.com.andreramosdev.bis14.control;

import android.view.MotionEvent;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import br.com.andreramosdev.bis14.interfaces.ButtonDelegate;

/**
 * Created by andre on 11/08/15.
 */
public class Button extends CCLayer {
    private CCSprite buttonImage;
    private ButtonDelegate delegate;

    public Button (String buttonImage) {
        this.setIsTouchEnabled(true);
        this.buttonImage = CCSprite.sprite(buttonImage);
        addChild(this.buttonImage);
    }

    public void setDelegate(ButtonDelegate sender) {
        this.delegate = sender;
    }

    @Override
    protected void registerWithTouchDispatcher() {
        CCTouchDispatcher.sharedDispatcher()
                .addTargetedDelegate(this, 0, false);
    }

    @Override
    public boolean ccTouchesBegan(MotionEvent event) {

        CGPoint touchLocation = CGPoint.make(event.getX(), event.getY());
        touchLocation = CCDirector.sharedDirector().convertToGL(touchLocation);
        touchLocation = this.convertToNodeSpace(touchLocation);

        // Check Button touched
        if (CGRect.containsPoint(
                this.buttonImage.getBoundingBox(), touchLocation)) {
            delegate.buttonClicked(this);
        }

        return true;
    }
}
