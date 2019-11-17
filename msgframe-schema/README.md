MessagFrame Schema Language 
===

# Message


_query.mf_
```
version: 0.1

message QueryRequest {
  query: string
  records_per_page: integer
}

message QueryRequestResponse {
  next_token: option[string]
  result: QueryResult 
}

message QueryResult {
  
}

import msgframe.api.http

service QueryService {
  @http(method = GET, path = "/v1/query")
  def query(request:QueryRequest): QueryRequestResponse
} 


```

_msgframe/api/http.mf_
```
version: 0.1

option http {
  method: Method
  path: string
  description: optional[string]
}

enum Method {
  GET,
  POST,
  PUT,
  DELETE,
  PATCH
}

```

## Primitive Types


top-level
data
data structure schema
service 
API schema
function
def function_name(args, …): return_type
Primitive types
integer
float
boolean
string
utf-8
binary
mapping to text-oriented protocol like json should use base64 encoded strings
timestamp
any
enum
Data structure
optional[x]
array[x]
map[k, v]
message (like class) 
modularity
import via path, url
allow using alias
import xxx as yyy
Can refer xxx.page as yyy.page
spec
header:
Annotation
comment
REST path mapping
