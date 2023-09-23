package com.github.demchenkovv.javacore.level03.lecture11.task13;

public abstract class AbstractRobot
        implements Attackable, Defensable {

    private static int hitCount;

    public abstract String getName();

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = (int) (Math.random() * 4 + 1);

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4)
            attackedBodyPart = BodyPart.CHEST;
            hitCount = 0;
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = (int) (Math.random() * 4 + 1);

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.ARM;
        } else if (hitCount == 4) {
            defendedBodyPart = BodyPart.CHEST;
            hitCount = 0;
        }
        return defendedBodyPart;
    }
}
