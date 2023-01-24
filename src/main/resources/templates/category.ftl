<#import "templ/templ.ftl" as p>
<@p.pages>

<h2>Category</h2>

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
  <div class="col">
    <div class="card">
      <img src="/static/images/category/car.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Cart</h5>
        <p class="card-text">Tsadhsa sghad sa dashg</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="/static/images/category/car.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Beer</h5>
        <p class="card-text">Tsadhsa sghad sa dashgsads sad</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="/static/images/category/car.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Apple</h5>
        <p class="card-text">sad ghsadggsa</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="/static/images/category/car.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to
          additional content. This content is a longer.</p>
      </div>
    </div>
  </div>
</div>
</@p.pages>