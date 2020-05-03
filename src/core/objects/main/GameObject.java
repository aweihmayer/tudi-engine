package core.objects.main;

import core.objects.BaseObject;
import core.objects.components.BaseComponent;
import core.objects.components.ComponentList;
import core.objects.components.actions.ActionList;
import core.objects.components.body.Body;
import core.objects.components.movement.Movement;

public abstract class GameObject extends BaseObject {
    protected int registryStatus = 0; // 0 not yet added, 1 added, -1 removed

    public Body body;
    public Movement movement;
    public ActionList actions = new ActionList();
    public ComponentList<BaseComponent> components = new ComponentList<BaseComponent>();

// Registry

    public void setRegistryStatus(int i){ 		    this.registryStatus = i; 				    }

    public int getRegistryStatus(){ 				return this.registryStatus; 				}

    public boolean isRemovedFromRegistry(){ 		return this.getRegistryStatus() == -1; 		}
}
