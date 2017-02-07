package be.yildiz.module.physics;

import be.yildiz.common.gameobject.Movable;
import be.yildiz.common.id.EntityId;
import be.yildiz.common.vector.Point3D;
import be.yildiz.common.vector.Quaternion;

/**
 * @author Grégory Van den Borre
 */
public class DummyBody implements StaticBody, KinematicBody, DynamicBody, GhostObject {
    @Override
    public EntityId getId() {
        return EntityId.WORLD;
    }

    @Override
    public void attachTo(Movable other) {

    }

    @Override
    public void detach(Movable other) {

    }

    @Override
    public void addChild(Movable other) {

    }

    @Override
    public void attachToOptional(Movable other) {

    }

    @Override
    public Point3D getPosition() {
        return Point3D.ZERO;
    }

    @Override
    public Point3D getAbsolutePosition() {
        return Point3D.ZERO;
    }

    @Override
    public void setAbsolutePosition(Point3D pos) {

    }

    @Override
    public Point3D getDirection() {
        return Point3D.BASE_DIRECTION;
    }

    @Override
    public Point3D getAbsoluteDirection() {
        return Point3D.BASE_DIRECTION;
    }

    @Override
    public void scale(float x, float y, float z) {

    }

    @Override
    public void sleep(boolean sleeping) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void setDirection(float dirX, float dirY, float dirZ) {

    }

    @Override
    public void setDirection(Point3D direction) {

    }

    @Override
    public void setPosition(float posX, float posY, float posZ) {

    }

    @Override
    public void setPosition(Point3D position) {

    }

    @Override
    public void setOrientation(float x, float y, float z, float w) {

    }

    @Override
    public void setOrientation(Quaternion q) {

    }
}
