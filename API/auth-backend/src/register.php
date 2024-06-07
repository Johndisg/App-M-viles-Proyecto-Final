<?php
require_once '../config/db.php';
require_once 'User.php';

$input = json_decode(file_get_contents('php://input'), true);

if (isset($input['name'], $input['email'], $input['password'], $input['birthdate'])) {
    $user = new User($pdo);
    $userId = $user->create($input['name'], $input['email'], $input['password'], $input['birthdate']);
    echo json_encode(['user_id' => $userId]);
} else {
    echo json_encode(['error' => 'Invalid input']);
}
?>
