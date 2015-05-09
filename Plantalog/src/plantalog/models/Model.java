/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog.models;

import java.sql.ResultSet;

/**
 *
 * @author Simon
 */
public abstract class Model {
    public abstract void fromResultSet(ResultSet r);
}
