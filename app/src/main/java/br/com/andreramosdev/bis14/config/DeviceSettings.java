package br.com.andreramosdev.bis14.config;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

/**
 * Created by andre on 11/08/15.
 */
public class DeviceSettings {
    public static CGPoint screenResolution (CGPoint gcPoint) {
        return gcPoint;
    }

    public static float screenWidth () {
        return winSize().width;
    }

    public static float screenHeigth () {
        return winSize().height;
    }

    public static CGSize winSize () {
        return CCDirector.sharedDirector().winSize();
    }
}
