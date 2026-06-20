class Solution {

    private static final double EPS = 1e-6;

    public boolean solve(List<Double> gameCards){
        if(gameCards.size()==1){
            return Math.abs(gameCards.get(0)-24) <EPS;
        }
        
        for(int i=0;i<gameCards.size();i++){
            for(int j=i+1;j<gameCards.size();j++){
                if(i>j) continue;// remove duplicates

                List<Double> temp = new ArrayList<>();
                for(int k=0;k<gameCards.size();k++){
                    if(k!=i && k!=j){
                        temp.add(gameCards.get(k));
                    }
                }

                double a = gameCards.get(i); 
                double b = gameCards.get(j);

               List<Double> possibles = new ArrayList<>();

                possibles.add(a + b);
                possibles.add(a - b);
                possibles.add(b - a);
                possibles.add(a * b);

                if(Math.abs(b)>0.0){
                    possibles.add(a/b);
                }
                if(Math.abs(a)>0.0){
                    possibles.add(b/a);
                }

                for(double val:possibles){
                    temp.add(val);
                    if(solve(temp)==true) return true;
                    temp.remove(temp.size()-1);
                }
            }
        }
        return false;

    }

    public boolean judgePoint24(int[] cards) {

        List<Double> gameCards = new ArrayList<>();
        for(int i=0;i<cards.length;i++){
            gameCards.add( 1.0 * cards[i] );
        }
        return solve(gameCards);
        
    }
}