package com.mycompany.ed2;

public class TabelaHashLinear {

    private Aluno2[] tabela;
    private int tamanho;
    private double fatorialDeCarga;
    private static final Aluno2 APAGADO = new Aluno2("APAGADO");

    public TabelaHashLinear() {
        this.tabela = new Aluno2[13];
        this.tamanho = 0;
        this.fatorialDeCarga = 0.75;
    }

    public int hash(String chave) {
        int chaveCodificada = codificacao(chave);
        return chaveCodificada % this.tabela.length;
    }

    public Aluno2 get(String chave) {
        int sondagem = 0;
        int hash;
        
        hash = hash(chave);
        while (sondagem < tabela.length) {
            if (tabela[hash] != null && tabela[hash] != APAGADO) {
                hash = (hash(chave) + sondagem) % tabela.length;
            }

            if (tabela[hash] == null) {
                return null;
            } else if (tabela[hash].getMatricula().equals(chave)) {
                System.out.println(hash);
                return tabela[hash];
            } else {
                sondagem++;
            }
        }
        return null;
    }

    public void put(Aluno2 valor) {
        if ((double) this.tamanho / this.tabela.length >= this.fatorialDeCarga || this.tamanho == this.tabela.length) {
            resize();
        }
        int sondagem = 0;
        int hash;

        while (sondagem < tabela.length) {
            hash = (hash(valor.getMatricula()) + sondagem) % tabela.length;
            if (tabela[hash] == null || tabela[hash].equals(APAGADO)) {
                tabela[hash] = valor;
                this.tamanho++;
                return;
            } else {
                sondagem++;
            }
        }
    }

    public Aluno2 remove(String chave) {
        int sondagem = 0;
        int hash;

        while (sondagem < tabela.length) {
            hash = (hash(chave) + sondagem) % tabela.length;

            if (tabela[hash] == null) {
                return null;
            } else if (tabela[hash].getMatricula().equals(chave)) {
                Aluno2 aluno = tabela[hash];
                tabela[hash] = APAGADO;
                tamanho--;
                return aluno;
            } else {
                sondagem++;
            }
        }
        return null;
    }

    public void resize() {
        Aluno2[] tabelaAntiga = this.tabela;
        this.tabela = new Aluno2[this.tabela.length * 2];
        this.tamanho = 0;

        for (Aluno2 aluno : tabelaAntiga) {
            if (aluno != null) {
                this.put(aluno);
            }
        }
    }

    public int codificacao(String letra) {
        if (letra.equals("A")) {
            return 0;
        } else if (letra.equals("B")) {
            return 1;
        } else if (letra.equals("C")) {
            return 2;
        } else if (letra.equals("D")) {
            return 3;
        } else if (letra.equals("E")) {
            return 4;
        } else if (letra.equals("F")) {
            return 5;
        } else if (letra.equals("G")) {
            return 6;
        } else if (letra.equals("H")) {
            return 7;
        } else if (letra.equals("I")) {
            return 8;
        } else if (letra.equals("J")) {
            return 9;
        } else if (letra.equals("K")) {
            return 10;
        } else if (letra.equals("L")) {
            return 11;
        } else if (letra.equals("M")) {
            return 12;
        } else if (letra.equals("N")) {
            return 13;
        } else if (letra.equals("O")) {
            return 14;
        } else if (letra.equals("P")) {
            return 15;
        } else if (letra.equals("Q")) {
            return 16;
        } else if (letra.equals("R")) {
            return 17;
        } else if (letra.equals("S")) {
            return 18;
        } else if (letra.equals("T")) {
            return 19;
        } else if (letra.equals("U")) {
            return 20;
        } else if (letra.equals("V")) {
            return 21;
        } else if (letra.equals("W")) {
            return 22;
        } else if (letra.equals("X")) {
            return 23;
        } else if (letra.equals("Y")) {
            return 24;
        } else if (letra.equals("Z")) {
            return 25;
        }
        return -1;
    }
}
