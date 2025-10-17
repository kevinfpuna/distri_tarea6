import requests, configparser, sys, datetime

cfg = configparser.ConfigParser()
if not cfg.read('ConfigFile.properties'):
    print('Error: no se pudo leer ConfigFile.properties'); sys.exit(1)

BASE = cfg.get('Api','base',fallback='http://localhost:8100/api')
TOKEN = cfg.get('Api','token',fallback='')

def get_cliente(id_):
    try:
        r = requests.get(f"{BASE}/clientes/{id_}")
        if r.status_code == 200: 
            print(str(r.json()))
        else: print('Error ' + str(r.status_code))
    except requests.exceptions.RequestException as e:
        print('Error de conexión:', e)

def get_sucursales():
    try:
        r = requests.get(f"{BASE}/sucursales")
        if r.status_code == 200: 
            listado = r.json()
            for item in listado:
                print("      " + str(item))
        else: print('Error ' + str(r.status_code))
    except requests.exceptions.RequestException as e:
        print('Error de conexión:', e)

def get_transacciones(fecha):
    try:
        r = requests.get(f"{BASE}/transacciones", params={'fecha': fecha})
        if r.status_code == 200: 
            listado = r.json()
            for item in listado:
                print("      " + str(item))
        else: print('Error ' + str(r.status_code))
    except requests.exceptions.RequestException as e:
        print('Error de conexión:', e)

def post_transferencia(origen, destino, monto):
    try:
        headers = {'X-Token': TOKEN, 'Content-Type':'application/json'}
        datos = {'origenCuenta': origen, 'destinoCuenta': destino, 'monto': monto}
        r = requests.post(f"{BASE}/transferencias", json=datos, headers=headers)
        if r.status_code in (200,201): 
            print(r)
        else: 
            print('Error ' + str(r.status_code))
            print(str(r.json()))
    except requests.exceptions.RequestException as e:
        print('Error de conexión:', e)

def put_cliente(id_, nombre, direccion, telefono):
    try:
        headers = {'X-Token': TOKEN, 'Content-Type':'application/json'}
        datos = {'id': id_, 'nombre': nombre, 'direccion': direccion, 'telefono': telefono}
        r = requests.put(f"{BASE}/clientes/{id_}", json=datos, headers=headers)
        if r.status_code == 200: 
            print(r)
        else: 
            print('Error ' + str(r.status_code))
            print(str(r.json()))
    except requests.exceptions.RequestException as e:
        print('Error de conexión:', e)

def delete_beneficiario(id_):
    try:
        headers = {'X-Token': TOKEN}
        r = requests.delete(f"{BASE}/beneficiarios/{id_}", headers=headers)
        if r.status_code == 200: 
            print(r)
        else: 
            print('Error ' + str(r.status_code))
            print(str(r.text))
    except requests.exceptions.RequestException as e:
        print('Error de conexión:', e)

if __name__ == '__main__':
    print("Iniciando " + datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S"))
    
    print("Primer listado de sucursales:")
    get_sucursales()
    print("________________")
    
    print("Buscar cliente por ID:")
    cliente_id = int(input("Ingrese ID del cliente: "))
    get_cliente(cliente_id)
    print("________________")
    
    print("Buscar transacciones por fecha:")
    fecha = input("Ingrese fecha (YYYY-MM-DD): ")
    get_transacciones(fecha)
    print("________________")
    
    print("Crear nueva transferencia:")
    origen = input("Ingrese cuenta origen: ")
    destino = input("Ingrese cuenta destino: ")
    monto = float(input("Ingrese monto: "))
    post_transferencia(origen, destino, monto)
    print("________________")
    
    print("Actualizar cliente:")
    cliente_id = int(input("Ingrese ID del cliente a actualizar: "))
    nombre = input("Ingrese nuevo nombre: ")
    direccion = input("Ingrese nueva dirección: ")
    telefono = input("Ingrese nuevo teléfono: ")
    put_cliente(cliente_id, nombre, direccion, telefono)
    print("________________")
    
    print("Eliminar beneficiario:")
    beneficiario_id = int(input("Ingrese ID del beneficiario a eliminar: "))
    delete_beneficiario(beneficiario_id)
    print("________________")
    
    print("Segundo listado de sucursales:")
    get_sucursales()
    
    print("Finalizando " + datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S"))
