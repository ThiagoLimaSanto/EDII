package com.mycompany.ed2;

import java.util.ArrayList;

public class TabelaEncadiamentoTestes {

    private ArrayList<Aluno3>[] tabela;

    public TabelaEncadiamentoTestes() {
        this.tabela = new ArrayList[8];
    }

    public int hash(int chave) {
        return chave % this.tabela.length;
    }

    public Aluno3 get(int chave) {
        int hash = this.hash(chave);
        ArrayList<Aluno3> alunos = this.tabela[hash];

        if (alunos == null) {
            return null;
        }
        for (Aluno3 percorrerLista : alunos) {
            if (percorrerLista.getNum() == chave) {
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

    public void put(Aluno3 valor) {
        int hash = this.hash(valor.getNum());
        ArrayList<Aluno3> alunos = this.tabela[hash];

        if (alunos == null) {
            alunos = new ArrayList<Aluno3>();
            alunos.add(valor);
            this.tabela[hash] = alunos;
            return;
        }
        alunos.add(valor);
    }

    public Aluno3 remove(int chave) {
        int hash = this.hash(chave);

        ArrayList<Aluno3> alunos = this.tabela[hash];
        for (Aluno3 atual : alunos) {
            if (atual.getNum() == chave) {
                alunos.remove(atual);
                return atual;
            }
        }
        return null;
    }
}
