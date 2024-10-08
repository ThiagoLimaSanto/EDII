package com.mycompany.ed2;

public class TabelaHashLinearTestes {

    private Aluno3[] tabela;
    private int tamanho;
    private double fatorialDeCarga;
    public static final Aluno3 APAGADO = new Aluno3(Integer.MIN_VALUE);

    public TabelaHashLinearTestes() {
        this.tabela = new Aluno3[8];
        this.tamanho = 0;
        this.fatorialDeCarga = 0.75;
    }

    public int hash(int chave) {
        return chave % tabela.length;
    }

    public Aluno3 get(int chave) {
        int sondagem = 1;
        int hash;

        hash = hash(chave);
        while (sondagem <= tabela.length) {
            if (tabela[hash].getNum() == chave) {
                System.out.println(hash);
                return tabela[hash];
            }
            if (tabela[hash] == null || tabela[hash] == APAGADO) {
                return null;
            } else if (tabela[hash] != null) {
                hash = (hash(chave) + sondagem) % tabela.length;
            }
            sondagem++;
        }
        return null;
    }

    public void put(Aluno3 valor) {
        if ((double) this.tamanho / this.tabela.length >= this.fatorialDeCarga || this.tamanho == this.tabela.length) {
            resize();
        }
        int sondagem = 1;
        int hash;
        hash = hash(valor.getNum());
        while (sondagem <= tabela.length) {
            if (tabela[hash] != null) {
                hash = (hash(valor.getNum()) + sondagem) % tabela.length;
            }
            if (tabela[hash] == null || tabela[hash] == APAGADO) {
                tabela[hash] = valor;
                this.tamanho++;
                return;
            } else {
                sondagem++;
            }
        }
    }

    public void remove(int chave) {
        int sondagem = 1;
        int hash;

        hash = hash(chave);

        while (sondagem <= tabela.length) {
            if (tabela[hash].getNum() == chave) {
                Aluno3 aluno = tabela[hash];
                tabela[hash] = APAGADO;
                tamanho--;
                return;
            }
            if (tabela[hash] == null) {
                return;
            }
            sondagem++;
        }
        return;
    }

    public void resize() {
        Aluno3[] tabelaAntiga = this.tabela;
        this.tabela = new Aluno3[this.tabela.length * 2];
        this.tamanho = 0;

        for (Aluno3 aluno : tabelaAntiga) {
            if (aluno != null) {
                this.put(aluno);
            }
        }
    }
}
