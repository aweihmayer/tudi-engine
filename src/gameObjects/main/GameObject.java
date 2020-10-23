package gameObjects.main;

import gameObjects.BaseObject;
import gameObjects.components.BaseComponent;
import gameObjects.components.ComponentList;
import gameObjects.components.actions.ActionList;
import gameObjects.components.body.Body;
import gameObjects.components.movement.Movement;

public abstract class GameObject extends BaseObject {
    public int registryStatus = 0;

    public Body body;
    public Movement movement;
    public ActionList actions = new ActionList();
    public ComponentList<BaseComponent> components = new ComponentList<BaseComponent>();
}