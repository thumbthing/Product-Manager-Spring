const body = document.querySelector('tbody')
const createBody = document.querySelector('button')
const addArea = document.querySelector('createArea')

function getProducts() {
    // API_URL를 사용해 json 데이터 가져와서
    fetch("api/products")
    .then(res => res.json())
    .then(data => showProducts(data));
}

function showProducts(products) {
    body.innerHTML = ''

    products.forEach((product) => {

        productElem = document.createElement('tr')

        productElem.innerHTML =
            `
            <td>${product.no}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td>
                <a class="link-primary" href="#" href="/products/${product.no}/update">수정</a>
            </td>
            <td>
                <a class="link-primary" href="#" href="/products/${product.no}/delete">삭제</a>
            </td>`

        body.append(productElem);
    })

}
createBody.addEventListener("click", () => {
    addArea.innerHTML = ''
    console.log(addArea.innerHTML = '')
    createForm = document.createElement('form')

    createForm.innerHTML =
    `
    <div class="form-group max-width: 600px">
                <label for="name"></label>
                <div>
                    <h1 class="py-3 text-left">new product</h1>
                    <p>제품명</p>
                    <input class="row w-100" type="text" id="name" name="name" placeholder="product name">
                    <p>가격</p>
                    <input class="row w-100" type="int" id="price" name="price" placeholder="price">
                    <p>수량</p>
                    <input class="row w-100" type="int" id="stock" name="stock" placeholder="stock">
                </div>
            </div>
            <div>

            </div>
            <div class="row">
                <div class="col">
                <button class="w-100 h-20 btn btn-primary btn-lg" type="submit">add product</button>
                </div>
                <div class="col">
                    <button class="w-100 btn btn-secondary btn-lg"
                    onclick="location.href='/'" type="button">cancel </button>
                </div>
            </div>
    `
    addArea.append(createForm);
} )

function createProduct() {

}
getProducts()