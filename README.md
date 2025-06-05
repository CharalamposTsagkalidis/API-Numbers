# Number Classification API

This API receives one List of String inputs(numbers) and classifies each number as:
- Real
- Natural
- Whole

###  Request Body

```json
{
  "numbers": []
}
### Response Body
```json
-response body:
{
"naturalNumbers":[],
"wholeNumbers":[],
"realNumbers":[]
}
