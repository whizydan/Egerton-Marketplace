import { IUser } from '../interfaces'

export function makeCreateUserEntity() {
	return ({ email, password, userName }: IUser) => {
		if (!email) {
			throw new Error('Email required')
		}
		if (!password) {
			throw new Error('Password required')
		}
		if (!userName) {
			throw new Error('Username required')
		}
		return Object.freeze({
			getUserName: () => userName,
			getPasword: () => password,
			getEmail: () => email
		})
	}
}
