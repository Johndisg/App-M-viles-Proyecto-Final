<?php
require_once '../config/db.php';
require_once 'User.php';

$input = json_decode(file_get_contents('php://input'), true);

if (isset($input['email'], $input['password'])) {
    $user = new User($pdo);
    $userData = $user->findByEmail($input['email']);

    if ($userData && password_verify($input['password'], $userData['password'])) {
        echo json_encode(['message' => 'Login successful']);
    } else {
        echo json_encode(['error' => 'Invalid credentials']);
    }
} else {
    echo json_encode(['error' => 'Invalid input']);
}
?>
