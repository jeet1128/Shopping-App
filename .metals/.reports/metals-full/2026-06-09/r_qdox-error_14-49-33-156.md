error id: file:///C:/Users/makwa/OneDrive/Documents/Visual%20Studio%202012/shopping-app/src/test/java/com/shopping/ShoppingCartTest.java
file:///C:/Users/makwa/OneDrive/Documents/Visual%20Studio%202012/shopping-app/src/test/java/com/shopping/ShoppingCartTest.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[26,5]

error in qdox parser
file content:
```java
offset: 596
uri: file:///C:/Users/makwa/OneDrive/Documents/Visual%20Studio%202012/shopping-app/src/test/java/com/shopping/ShoppingCartTest.java
text:
```scala
package com.shopping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest{

    @Test
    void newCarHasZeroItemsAndZeroSubtotal()
    {
        ShoppingCart cart = new ShoppingCart();

        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getSubtotal());

    }

    @Test
    void addItemIncreasesItemCountAndSubtotal90
    {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 10.0, 2);

        assertEquals(2, cart.getItemCount());
        assertEquals(20.0, cart.getSubtotal());
    }@@

    @Test
    void addMultipleItemsCalculatesSubtotalCorrectly()
    {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Book", 10.0, 2);
        cart.addItem("Pen", 2.0, 5);

        assertEquals(7, cart.getItemCount());
        assertEquals(30.0, cart.getSubtotal());

    }

    @Test
    void editQuantityUpdatesItemCountAndSubtotal()
    {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Book", 19.0, 2);
        cart.editQuantity(1,5);

        assertEquals(5, cart.getItemCount());
        assertEquals(50.0, cart.getSubtotal());
    }

    @Test
void removeItemUpdatesCart()
{
    ShoppingCart cart = new ShoppingCart();

    cart.addItem("Book", 10.0, 2);
    cart.addItem("Pen", 2.0, 5);

    cart.removeItem(1);

    assertEquals(5, cart.getItemCount());
    assertEquals(10.0, cart.getSubtotal());
}

@Test
void totalIncludesIllinoisTaxAndStandardShipping()
{
    ShoppingCart cart = new ShoppingCart();

    cart.addItem("Book", 10.0, 2);
    assertEquals(31.20, cart.getTotal("IL", ShippingOption.STANDARD), 0.01);
}

@Test
void totalIncludesFreeStandardShippingOverFifty()
{
    ShoppingCart cart = new ShoppingCart();
    cart.addItem("Shoes", 60.0, 1);

    assertEquals(63.60, cart.getTotal("IL", ShippingOption.STANDARD), 0.01);
}

@Test
void totalIncludesNextDayShipping()
{
    ShoppingCart cart = new ShoppingCart();

    cart.addItem("Book", 10.0, 2);
    assertEquals(46.20, cart.getTotal("IL", ShippingOption.NEXT_DAY), 0.01);
}

}
```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	java.base/java.lang.Thread.run(Thread.java:840)
```
#### Short summary: 

QDox parse error in file:///C:/Users/makwa/OneDrive/Documents/Visual%20Studio%202012/shopping-app/src/test/java/com/shopping/ShoppingCartTest.java