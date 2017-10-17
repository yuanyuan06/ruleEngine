def sayHaHa(def order){
    old = order.docNum
    order.docNum = "doc_num"
    println "sayHaHa haha change you data: "+  old +   " --> " + order.docNum
    order.docNum
    sayHelo(order)
}