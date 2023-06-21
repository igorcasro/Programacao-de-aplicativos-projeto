-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21/06/2023 às 19:11
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeto_planejador_financeiro`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nome`) VALUES
(9, 'Automóvel'),
(10, 'Educação'),
(11, 'Moradia'),
(12, 'Alimentação'),
(13, 'Poupança'),
(14, 'Salário'),
(15, 'Venda');

-- --------------------------------------------------------

--
-- Estrutura para tabela `despesa`
--

CREATE TABLE `despesa` (
  `id_despesa` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `codigo_categoria` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `frequencia` int(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `despesa`
--

INSERT INTO `despesa` (`id_despesa`, `nome`, `codigo_categoria`, `data`, `frequencia`, `valor`) VALUES
(8, 'Combustível', 9, '2023-06-21 16:46:22', 0, 800),
(9, 'IPVA', 9, '2023-06-21 19:34:50', 1, 3500),
(10, 'Seguro', 9, '2023-06-21 19:35:06', 1, 4500),
(11, 'Mensalidade Escolar', 10, '2023-06-21 19:35:38', 0, 2500),
(12, 'Material Escolar', 10, '2023-06-21 19:35:56', 1, 1000),
(13, 'Aluguel', 11, '2023-06-21 19:36:28', 0, 2500),
(14, 'Mercado', 12, '2023-06-21 19:36:54', 0, 1040);

-- --------------------------------------------------------

--
-- Estrutura para tabela `fundo_ocasional`
--

CREATE TABLE `fundo_ocasional` (
  `id_fundo_ocasional` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `frequencia` int(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `fundo_ocasional`
--

INSERT INTO `fundo_ocasional` (`id_fundo_ocasional`, `nome`, `data`, `frequencia`, `valor`) VALUES
(4, 'IPVA', '2023-06-21 16:47:22', 0, 300),
(5, 'Seguro', '2023-06-21 16:47:38', 0, 375),
(6, 'Material Escolar', '2023-06-21 16:47:51', 0, 85),
(7, 'Excedente Junho', '2023-05-01 03:00:00', 1, 5200);

-- --------------------------------------------------------

--
-- Estrutura para tabela `investimento`
--

CREATE TABLE `investimento` (
  `id_investimento` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `frequencia` int(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `investimento`
--

INSERT INTO `investimento` (`id_investimento`, `nome`, `data`, `frequencia`, `valor`) VALUES
(5, 'Poupança', '2023-06-21 16:46:47', 0, 2200),
(6, 'Poupança', '2023-06-21 16:47:02', 1, 7000);

-- --------------------------------------------------------

--
-- Estrutura para tabela `rendimento`
--

CREATE TABLE `rendimento` (
  `id_rendimento` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `codigo_categoria` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `frequencia` int(11) NOT NULL,
  `valor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `rendimento`
--

INSERT INTO `rendimento` (`id_rendimento`, `nome`, `codigo_categoria`, `data`, `frequencia`, `valor`) VALUES
(15, 'Salário Mensal', 14, '2023-06-21 16:44:45', 0, 10000),
(16, '13º Salário', 14, '2023-06-21 16:45:12', 1, 8000),
(17, 'Férias', 14, '2023-06-21 16:45:33', 1, 8000),
(18, 'Notebook', 15, '2023-06-21 16:45:48', 1, 5000);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Índices de tabela `despesa`
--
ALTER TABLE `despesa`
  ADD PRIMARY KEY (`id_despesa`),
  ADD KEY `fk_codigo_categoria` (`id_despesa`);

--
-- Índices de tabela `fundo_ocasional`
--
ALTER TABLE `fundo_ocasional`
  ADD PRIMARY KEY (`id_fundo_ocasional`);

--
-- Índices de tabela `investimento`
--
ALTER TABLE `investimento`
  ADD PRIMARY KEY (`id_investimento`);

--
-- Índices de tabela `rendimento`
--
ALTER TABLE `rendimento`
  ADD PRIMARY KEY (`id_rendimento`),
  ADD KEY `fk_codigo_categoria` (`codigo_categoria`) USING BTREE;

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `despesa`
--
ALTER TABLE `despesa`
  MODIFY `id_despesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `fundo_ocasional`
--
ALTER TABLE `fundo_ocasional`
  MODIFY `id_fundo_ocasional` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `investimento`
--
ALTER TABLE `investimento`
  MODIFY `id_investimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `rendimento`
--
ALTER TABLE `rendimento`
  MODIFY `id_rendimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
