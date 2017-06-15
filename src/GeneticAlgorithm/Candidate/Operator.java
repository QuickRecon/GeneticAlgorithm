package GeneticAlgorithm.Candidate;

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
            return input1 / input2;
        }
    },
    SUBTRACT {
        @Override
        public int Operate(int input1, int input2) {
            return input1 - input2;
        }
    },
    CONSTANT{
        @Override
        public int Operate(int input1, int input2) {
            return 0;
        }
    },
    COLLECTIVE_INTEGER_FETCH{
        @Override
        public int Operate(int input1, int input2) {
            try{
                return (int) CollectivePool.IntegerCollective.get(input1);
            } catch (IndexOutOfBoundsException e) {
                return 0;
            }
        }
    },
    COLLECTIVE_INTEGER_ADD{
        @Override
        public int Operate(int input1, int input2) {
            try{
                CollectivePool.IntegerCollective.add(input1, input2);
                return 0;
            } catch (IndexOutOfBoundsException e) {
                return 1;
            }
        }
    },
    COLLECTIVE_INTEGER_SET{
        @Override
        public int Operate(int input1, int input2) {
            try{
                CollectivePool.IntegerCollective.set(input1, input2);
                return 0;
            } catch (IndexOutOfBoundsException e) {
                return 1;
            }
        }
    };
    public abstract int Operate(int input1, int input2);
}
