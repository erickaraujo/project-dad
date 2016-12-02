/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.ejb.Stateless;

/**
 *
 * @author erick.araujo
 */

@Stateless
public class EstadoDTO {
    private Integer id;
    private String nome;
    private String sigla;
    
    public EstadoDTO(){
    }
    
    public EstadoDTO(Integer id, String nome, String sigla){
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}