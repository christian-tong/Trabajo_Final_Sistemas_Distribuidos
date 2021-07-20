/*
 * To change this license header, choose License Headers in Project Proestties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Estudiante;
import java.util.List;

/**
 *
 * @author Kri5ho
 */
public interface CRUD {
    public List listar();
    public Estudiante list(int id);
    public boolean add(Estudiante est);
    public boolean edit(Estudiante est);
    public boolean eliminar(int id);
}
