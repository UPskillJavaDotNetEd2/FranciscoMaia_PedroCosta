package org.upskill;

/**
 * Enumeração que representa os diferentes tipos de clientes.
 * Cada tipo de cliente tem uma representação textual personalizada.
 */
public enum TipoCliente {
    /**
     * Tipo de cliente regular.
     * @return Representação textual: "Regular".
     */
    REGULAR {
        @Override
        public String toString() {
            return "Regular";
        }
    },

    /**
     * Tipo de cliente esporádico.
     * @return Representação textual: "Esporádico".
     */
    ESPORADICO {
        @Override
        public String toString() {
            return "Esporádico";
        }
    },

    /**
     * Tipo de cliente convidado.
     * @return Representação textual: "Convidado".
     */
    CONVIDADO {
        @Override
        public String toString() {
            return "Convidado";
        }
    }
}
