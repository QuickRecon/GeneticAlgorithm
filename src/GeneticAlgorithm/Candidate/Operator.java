package GeneticAlgorithm.Candidate;

import GeneticAlgorithm.Candidate.CollectivePool;

/**
 * Created by aren on 15/06/17.
 */
public enum Operator {
    ADD {
        @Override
        public int Operate(int input1, int input2) {
            return input1 + input2;
        }
    },
    MULTIPLY {
        @Override
        public int Operate(int input1, int input2) {
            return input1 * input2;
        }
    },
    DIVIDE {
        @Override
        public int Operate(int input1, int input2) {
            if (input2 == 0) {
                return 1;
            }
            return input1 / input2;
        }
    },
    SUBTRACT {
        @Override
        public int Operate(int input1, int input2) {
            return input1 - input2;
        }
    },
    CONSTANT {
        @Override
        public int Operate(int input1, int input2) {
            return 0;
        }
    },
    COLLECTIVE_INTEGER_FETCH {
        @Override
        public int Operate(int input1, int input2) {
            try {
                return CollectivePool.Get(input1);
            } catch (NullPointerException e) {
                return 0;
            }
        }
    },
    COLLECTIVE_INTEGER_ADD {
        @Override
        public int Operate(int input1, int input2) {
            try {
                CollectivePool.Add(input1);
                return 0;
            } catch (NullPointerException e) {
                return 1;
            }
        }
    },
    COLLECTIVE_INTEGER_SET {
        @Override
        public int Operate(int input1, int input2) {
            try {
                CollectivePool.Set(input1, input2);
                return 0;
            } catch (NullPointerException e) {
                return 1;
            }
        }
    };

    public abstract int Operate(int input1, int input2);
}
