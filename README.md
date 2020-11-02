# Read Me First
Developed by Sohil Chhabriya.
Email Id: sohil8chhabriya@gmail.com

# Getting Started

* Run the Application as Spring Boot App.
* Go to http://localhost:8080/
* See all the supported APIs.


<p><b>POST: (<i>/api/products</i>)</b> <a href="">Add Product</a></p>

<code>{
	product: {
		"name": "Samsung TV",
		"description": "description of the product",
		"price": 12345,
		"pictureUrl": "http://www.google.com",
		"productCategory": {
			"category": {
				"name": "Electronics"
			},
			"subCategory": {
				"name": "TV"
			}
		},
		"attribute": {
			"screen": "32Inch"
		}
	},
	// "forceAddCategory":true, (if you try to add category which is not present)
    // "forceAddSubCategory":true, (if you try to add subcategory which is not present, (In this case by default forceAddAttribute=true))
	// "forceAddAttribute": true, (Don't Allow to add product with disAllowed Attributes unless forceAddAttribute is true)
}
</code>
<p><b>GET: (<i>/api/products</i>)</b> <a href="/api/products">Get all Products</a></p>
<p><b>GET: (<i>/api/products/{id}</i>)</b> <a href="/api/products/1">Get Product By Id</a></p>

<p><b>GET: (<i>/api/find/category/</i>)</b> <a href="">Get Products By Category</a></p>
<code>
{
    "category": {
        "name": "Electronics"
    }
}
</code>

<p><b>GET: (<i>/api/find/subcategory/</i>)</b> <a href="">Get Products By SubCategory</a></p>
<code>
{
    "subCategory": {
        "name": "TV"
    }
}
</code>

<p><b>GET: (<i>/api/find/subcategory/attributes</i>)</b> <a href="">Get attributes of SubCategory</a></p>
<code>
{
    "subCategory": {
        "name": "TV"
    }
}
</code>

<p><b>PUT: (<i>/api/products/</i>)</b> <a href="">Update Product</a></p>

<code>
{
    "product": {
        "id": 1,
        "name": "Motorola m1 updated",
        "description": "description of the product",
        "price": 12345.0,
        "pictureUrl": "http://www.google.com",
        "productCategory": {
            "id": 1,
            "category": {
                "id": 1,
                "name": "Electronics"
            },
            "subCategory": {
                "id": 1,
                "name": "Mobile",
                "attribute": [
                    "screen",
                    "RAM"
                ]
            }
        },
        "attribute": {
            "screen": "6Inch",
            "RAM": "6Gb"
        }
    }
}
</code>

<p><b>DELETE: (<i>/api/products/{id}</i>)</b> <a href="">Delete Product By Id</a></p>
