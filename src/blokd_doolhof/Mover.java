/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;
/**
 *
 * @author Asus
 */
public interface Mover {
    
    public void move(String direction);
    
    public void setHuidigVeld();
    
    public Veld getHuidigVeld();
    
    public void setHuidigVeld(Veld veld);
    
}
