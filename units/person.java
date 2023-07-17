    protected int[] damage; //Урон
    protected int attack; //Сила удара

    protected Coordinats coordinats;
    protected int numberTeam;


    public Person(String name,float hp, int[] damage, int attack, int x, int y, int numberTeam) {
        this.hp = hp;
        this.curHp = curHp;
        this.name = name;
        this.damage = damage;
        this.attack = attack;
        this.coordinats = new Coordinats(x,y);
        this.numberTeam = numberTeam;
    }

    public int findNearest(ArrayList<Person> teamProtivnic){


        double minR = Coordinats.Rastoynie(coordinats.x, teamProtivnic.get(0).coordinats.x,coordinats.y,
                teamProtivnic.get(0).coordinats.y);
        int k = 0;

        for (int i = 1; i < 10; i++) {
            double R = Coordinats.Rastoynie(coordinats.x, teamProtivnic.get(i).coordinats.x,coordinats.y,
                    teamProtivnic.get(i).coordinats.y);
            if(R<minR) {
                minR = R;
                k = i;
            }
        }

        System.out.println(getClass().getName()+" "+name+"- "+teamProtivnic.get(k).name+" "+minR);
        return k;
    }

    @Override
    public void step(ArrayList<Person> teamProtivnic) {
        findNearest(teamProtivnic);
    }

    @Override
    public String getInfo(){


        return "Персонаж:" + getClass().getName() +" Имя: "+name + " " + coordinats;
    }
}