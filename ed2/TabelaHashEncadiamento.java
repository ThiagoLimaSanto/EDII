package com.mycompany.ed2;

import java.util.ArrayList;

public class TabelaHashEncadiamento {

    private ArrayList<Aluno>[] tabela;

    public TabelaHashEncadiamento() {
        this.tabela = new ArrayList[7];
    }

    public int hash(String chave) {
        int chaveCodificada = codificacao(chave);
        return chaveCodificada % this.tabela.length;
    }

    public Aluno get(String chave) {
        int hash = this.hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        if (alunos == null) {
            return null;
        }
        for (Aluno percorrerLista : alunos) {
            if (percorrerLista.getMatricula().equals(chave)) {
                return percorrerLista;
            }
        }
        return null;
    }

    public void imprimir() {
        System.out.println("Tabela Hash com Encadeamento:");
        for (int i = 0; i < tabela.length; i++) {
            System.out.print("Posicao " + i + ": ");
            if (tabela[i] == null) {
                System.out.println("[vazio]");
            } else {
                System.out.println(tabela[i]);
            }
        }
    }

    public void put(Aluno valor) {
        int hash = this.hash(valor.getMatricula());
        ArrayList<Aluno> alunos = this.tabela[hash];

        if (alunos == null) {
            alunos = new ArrayList<Aluno>();
            alunos.add(valor);
            this.tabela[hash] = alunos;
        }
        alunos.add(valor);
    }

    public Aluno remove(String chave) {
        int hash = this.hash(chave);

        ArrayList<Aluno> alunos = this.tabela[hash];
        for (Aluno atual : alunos) {
            if (atual.getMatricula().equals(chave)) {
                alunos.remove(atual);
                return atual;
            }
        }
        return null;
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
