<#import "templ/templ.ftl" as c>
<@c.pages>


    <h2> Product From  ${category} </h2>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

    <div class="row row-cols-2 row-cols-md-4 g-4">

        <#if allProductByCategory??>
            <#list allProductByCategory as product>
                <div class="col">
                    <div class="card">

                        <form action="/cart" method="post">

                        <input type="hidden" name="id" id="id_" value="${product.id}">
                        <img src="${product.image}" class="card-img-top" alt="${product.name}">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.description}</p>
                            <p class="card-text">name category: ${product.categories.name}</p>
                            <h5 class="card-title">price: <a>${product.price}</a></h5>

                            <div>
                            <button class="minus btn btn-success"> - </button>
                                <input type="text" name="quantity" value="1" size="3">
                            <button class="plus btn btn-success"> + </button>
                                <p class="my_text"> </p>
                            </div>


                            <button type="submit" class="btn btn-primary"> Add to Cart</button>
                            <a href="/" class="card-link" class="btn btn-success">to category</a>
                        </div>
                        </form>
                    </div>
                </div>
            </#list>
        </#if>

    </div>

</@c.pages>