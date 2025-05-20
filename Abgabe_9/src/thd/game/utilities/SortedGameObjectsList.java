package thd.game.utilities;

import thd.gameobjects.base.GameObject;

import java.util.LinkedList;

/**
 * A list for game objects that sorts them on insert by distance to background.
 */
public class SortedGameObjectsList extends LinkedList<GameObject> {

    /**
     * Constructs an empty SortedGameObjectsList.
     */
    public SortedGameObjectsList() {
        super();
    }

    @Override
    public boolean add(GameObject gameObject) {
        int indexToSortIn = 0;
        for (GameObject other : this) {
            if (other.getDistanceToBackground() >= gameObject.getDistanceToBackground()) {
                break;
            }
            indexToSortIn++;
        }
        this.add(indexToSortIn, gameObject);
        return true;
    }
}
