package com.ecommerce.exception;

import java.time.LocalDateTime;

public class ErroResposta {
        
    private Integer status;
    private String titulo;
    private LocalDateTime dataHora;

    public ErroResposta(Integer status, String titulo, LocalDateTime dataHora) {
        this.status = status;
        this.titulo = titulo;
        this.dataHora = dataHora;
    }


    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    
}
