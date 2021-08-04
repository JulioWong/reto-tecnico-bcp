# Reto técnico BCP


- Generar token de autenticación JWT


	http://localhost:8040/token
	
	Method: GET
	
- Crear / actualizar los tipos de cambio

	http://localhost:8040/api/exchange_rate
	
	Method: POST
	
	Request:
	
	{
		"moneda_origen": "PEN",
		"moneda_destino": "CAD",
		"tipo_cambio": 3.12
	}
	
- Aplicar tipo de cambio

	http://localhost:8040/api/exchange_rate/calc
	
	Method: POST
	
	Request:
	
	{
		"moneda_origen": "PEN",
		"moneda_destino": "USD",
		"monto": 760
	}