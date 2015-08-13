package br.com.andreramosdev.bis14.engines;

import org.cocos2d.layers.CCLayer;

import java.util.Random;

import br.com.andreramosdev.bis14.config.Assets;
import br.com.andreramosdev.bis14.interfaces.MeteorsEngineDelegate;
import br.com.andreramosdev.bis14.objects.Meteor;

/**
 * Created by andre on 11/08/15.
 */
public class MeteorsEngine extends CCLayer {
    private MeteorsEngineDelegate delegate;

    public MeteorsEngine() {
        this.schedule("meteorsEngine", 1.0f / 10f);
    }

    public void meteorsEngine(float dt) {
        // sorte 1 em 30: gera um novo meteoro!
        if(new Random().nextInt(30) == 0) {
            this.getDelegate().createMeteor(new Meteor(Assets.METEOR));
        }
    }

    public void setDelegate(MeteorsEngineDelegate delegate) {
        this.delegate = delegate;
    }

    public MeteorsEngineDelegate getDelegate() {
        return delegate;
    }
}
