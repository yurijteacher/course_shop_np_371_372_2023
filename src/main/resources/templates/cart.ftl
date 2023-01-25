<#import "templ/templ.ftl" as c>
<@c.pages>
    <h2> Cart </h2>

    <#if itemCart??>
    <#list itemCart as item>
        <ul>
            <li><img src="${item.product.image}" alt="${item.product.name}" height="25px"></li>
            <li>${item.product.name}</li>
            <li>${item.product.description}</li>
            <li>${item.quantity}</li>
            <li>${item.product.price}</li>
            <li>${item.product.price*item.quantity}</li>
        </ul>
    </#list>
    </#if>


    <p> ${totalValue} </p>
    <p> ${totalEl} </p>




</@c.pages>