<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

$requestMethod = $_SERVER["REQUEST_METHOD"];
$requestUri = $_SERVER['REQUEST_URI'];

if ($requestMethod === 'POST') {
    if ($requestUri === '/register') {
        require '../src/register.php';
    } elseif ($requestUri === '/login') {
        require '../src/login.php';
    } else {
        echo json_encode(['error' => 'Endpoint not found']);
    }
} else {
    echo json_encode(['error' => 'Invalid request method']);
}
?>
