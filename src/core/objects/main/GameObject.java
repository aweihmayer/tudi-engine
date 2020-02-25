package core.objects.main;

import core.objects.BaseObject;
import core.objects.components.BaseComponent;
import core.objects.components.ComponentList;

public class GameObject extends BaseObject {
    protected int registryIndex = -1;

    protected int updateHandlerIndex;

    protected int drawHandlerIndex;
    protected int drawHandlerLayer;

    protected int collisionHandlerIndex;
    protected int collisionHandlerCheckStatus = 1;

    public ComponentList<BaseComponent> components = new ComponentList<BaseComponent>();

// Registry

    public void setRegistryIndex(int i){ 		    this.registryIndex = i; 				    }

    public int getRegistryIndex(){ 					return this.registryIndex; 					}

    public boolean isRemovedFromRegistry(){ 		return this.getRegistryIndex() == -2; 		}

// Update

    public void setUpdateHandlerIndex(int i) { 	    this.updateHandlerIndex = i;                }

    public int getUpdateHandlerIndex() { 		    return this.updateHandlerIndex; 	        }

// Draw

    public void setDrawHandlerIndex(int i) { 	    this.drawHandlerIndex = i;                  }

    public int getDrawHandlerIndex() { 			    return this.drawHandlerIndex; 	            }

    public int getDrawHandlerLayer() {              return this.drawHandlerLayer;               }

// Collision

    public void setCollisionHandlerIndex(int i) {   this.collisionHandlerIndex = i;             }

    public int getCollisionHandlerIndex() {         return this.collisionHandlerIndex; 	        }

    public void setCollisionCheckStatus(int s) {	this.collisionHandlerCheckStatus = s; 	    }

    public int getCollisionCheckStatus() {			return this.collisionHandlerCheckStatus;    }
}
