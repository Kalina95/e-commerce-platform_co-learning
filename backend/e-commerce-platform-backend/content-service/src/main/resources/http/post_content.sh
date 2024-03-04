curl \
-d '{"contentId": 2, "name": "someName", "component": 2, "literals": [{"literalId": 0, "component": null, "value": "someValue", "type": "someType", "content": null}], "images": [], "icons":[]}' \
-H 'Content-Type: application/json' \
-X POST http://localhost:8082/content