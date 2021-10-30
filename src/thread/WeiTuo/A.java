package thread.WeiTuo;

class A implements Observer{
    /**
     * 被委托的对象的唯一标识
     */
    private String name;
    A(String name){
        this.name=name;
    }
    /**
     * 被委托对象要做的事情
     * @param data:事情数据
     */
    @Override
   public void doEvent(Subject s,Object data) {
        // TODO Auto-generated method stub
        System.out.println(s.getName()+"你好，"+"我是"+name+"，你让我"+data+"的事已经做完了！");
    }
    
}