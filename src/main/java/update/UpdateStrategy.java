package update;

import base.Item;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 28/04/13
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
public interface UpdateStrategy {

    void update(Item currentItem);

    String getObjectName();
}
